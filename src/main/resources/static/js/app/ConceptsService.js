'use strict';

angular.module('gastosPerApp').factory('ConceptsService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {

                loadAllConcepts: loadAllConcepts,
                getAllConcepts: getAllConcepts,
                getConcepts: getConcepts,
                createConcepts: createConcepts,
                updateConcepts: updateConcepts,
                removeConcepts: removeConcepts
            };

            return factory;

            function loadAllConcepts() {
                console.log('Fetching all concepts');
                var deferred = $q.defer();
                $http.get(urls.CONCEPTS_SERVICE_API)
                    .then(function (response) {
                            console.log('Fetched successfully all concepts');
                            $localStorage.concepts = response.data.content;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading concepts');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllConcepts(){
                return $localStorage.concepts;
            }

            function getConcepts(id) {
                console.log('Fetching concepts with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.CONCEPTS_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully concepts with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading concepts with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createConcepts(concept) {

                console.log('Creating concepts----------> '+concept.name);

                var deferred = $q.defer();
                $http.post(urls.CONCEPTS_SERVICE_API, concept)
                    .then(
                        function (response) {
                            loadAllConcepts();
                            deferred.resolve(response.name);
                        },
                        function (errResponse) {
                           console.error('Error while creating concepts : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateConcepts(concept, id) {
                console.log('Updating concepts with id '+id);
                var deferred = $q.defer();
                $http.put(urls.CONCEPTS_SERVICE_API + id, concept)
                    .then(
                        function (response) {
                            loadAllConcepts();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating User with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeConcepts(id) {
                console.log('Removing User with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.CONCEPTS_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllConcepts();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing User with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);