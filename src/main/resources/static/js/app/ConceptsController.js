'use strict';

angular.module('insApp').controller('ConceptsController',
    ['ConceptsService', '$scope',  function(ConceptsService, $scope) {

        var self = this;
        self.concept = {};
        self.concepts=[];

        self.submit = submit;
        self.getAllConcepts = getAllConcepts;
        self.createConcepts = createConcepts;
        self.updateConcepts = updateConcepts;
        self.removeConcepts = removeConcepts;
        self.editConcepts = editConcepts;
        self.reset = reset;
        self.numberOfPages = numberOfPages;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;
        self.pageCur=1;
        self.itemPerPage=2;
        self.maxPage=1;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;



        function numberOfPages (arrayLenght) {

            return Math.ceil(arrayLenght/self.itemPerPage);
        }

        $scope.$watch('pageCur + itemPerPage',function () {
            var begin =((self.pageCur-1)*self.itemPerPage),end=begin+self.itemPerPage;

            self.filteredItems=self.concepts.slice(begin,end);
        })

        function submit() {
            console.log('Submitting');
            if (self.concept.id === undefined || self.concept.id === null) {
                console.log('Saving New concepts', self.concept);
                createConcepts(self.concept);
            } else {
                updateConcepts(self.concept, self.concept.id);
                console.log('concepts updated with id ', self.concept.id);
            }
        }

        function createConcepts(concept) {
            console.log('About to create concept');
            ConceptsService.createConcepts(concept)
                .then(
                    function (response) {
                        console.log('Concepts created successfully');
                        self.successMessage = 'concepts created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.concept={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating User');
                        self.errorMessage = 'Error while creating concepts: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateConcepts(concept, id){
            console.log('About to update concepts');
            ConceptsService.updateConcepts(concept, id)
                .then(
                    function (response){
                        console.log('concepts updated successfully');
                        self.successMessage='concepts updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating User');
                        self.errorMessage='Error while updating concepts '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeConcepts(id){
            console.log('About to remove User with id '+id);
            ConceptsService.removeConcepts(id)
                .then(
                    function(){
                        console.log('concepts '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing concepts '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllConcepts(){
            self.concepts=ConceptsService.getAllConcepts();
            console.log(self.concepts);
            return ConceptsService.getAllConcepts();

        }

        function editConcepts(id) {
            self.successMessage='';
            self.errorMessage='';
            ConceptsService.getConcepts(id).then(
                function (concept) {
                    self.concept = concept;
                },
                function (errResponse) {
                    console.error('Error while removing concepts ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.concept={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);