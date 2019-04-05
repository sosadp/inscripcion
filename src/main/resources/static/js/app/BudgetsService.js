'use strict';

angular.module('gastosPerApp').factory('BudgetsService',
    ['$localStorage','$http','$q','urls',
        function ($localStorage, $http,$q,urls) {

            var factory={

                loadAllBudget: loadAllBudget,
                getAllBudget: getAllBudget,
                getBudget: getBudget,
                createBudget: createBudget,
                updateBudget: updateBudget,
                removeBudget: removeBudget
            };

            return factory;

            function loadAllBudget() {
                console.log('fetching all budgets');
                var deferred =$q.defer();
                $http.get(urls.BUDGETS_SERVICES_API)
                    .then(function (response) {
                        console.log('Fetched successfully all budget');
                        $localStorage.budgets=response.data;
                        deferred.resolve(response);
                    },
                      function (errResponse) {
                            console.log('Error while loading budget');
                            deferred.reject(errResponse);
                      }
                        );
                return deferred.promise;

            }

            function getAllBudget() {
                return $localStorage.budgets;
            }

            function getBudget(id) {
                console.log('Fetching budget with id : '+id);
                var deferred=$q.defer();
                $http.get(urls.BUDGETS_SERVICES_API+id)
                    .then(
                      function (response) {
                          console.log('Fetched successfully budget with id : '+id);
                          deferred.resolve(response.data);
                      },
                        function (errResponse) {
                            console.error('Error while loading budget with id : ' + id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createBudget(budget) {

                console.log('Creating budget');

                var deferred =$q.defer();
                $http.post(urls.BUDGETS_SERVICES_API,budget)
                    .then(
                        function (responde) {
                            loadAllBudget();
                            deferred.resolve(responde.data);
                        },
                        function (errResponde) {
                            console.error('Error while creating budget : '+errResponde);
                            deferred.reject(errResponde);
                        }
                    );
                return deferred.promise;
            }

            function updateBudget(budget, id) {

                console.log('Updating budget with id: '+id);
                var deferred =$q.defer();
                $http.put(urls.BUDGETS_SERVICES_API+id,budget)
                    .then(
                        function (responde) {
                            loadAllBudget();
                            deferred.resolve(responde.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating budget with id: '+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeBudget(id) {
                console.log('Removing Budget with id: '+id);
                var deferred = $q.defer();
                $http.delete(urls.BUDGETS_SERVICES_API+id)
                    .then(
                        function (response) {
                            loadAllBudget();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.log('Error while removing Budget with id: '+id);
                            deferred.reject(errResponse);
                        }
                    );

                return deferred.promise;

                
            }

    }
]);