'use strict';

angular.module('gastosPerApp').controller('BudgetsController',
    ['BudgetsService','$scope',function (BudgetsService,$scope) {

        var self=this;
        self.budget={};
        self.budgets=[];

        self.submit=submit;
        self.getAllBudgets = getAllBudgets;
        self.createBudgets = createBudgets;
        self.updateBudgets = updateBudgets;
        self.removeBudgets = removeBudgets;
        self.editBudgets = editBudgets;
        self.reset = reset;

        self.successMessage='';
        self.errorMessage='';
        self.done=false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Submitting');
            if (self.budget.id=== undefined || self.budget.id===null){
                console.log('Saving new Budget', self.budget);
                createBudgets(self.budget);
            } else {
                updateBudgets(self.budget,self.budget.id);
                console.log('Budget updated with id: ',self.budget.id);
            }

            
        }

        function createBudgets(budget) {
            console.log('About to create budget');
            BudgetsService.createBudget(budget)
                .then(
                    function (response) {
                        console.log('Budget created successfully');
                        self.successMessage='Budget created successfully';
                        self.errorMessage='';
                        self.done=true;
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.log('Error while creating Budget');
                        self.errorMessage='Error while creating budget: '+ errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                )

        }

        function updateBudgets(budget, id) {
            console.log('About to updated budget');
            BudgetsService.updateBudget(budget,id)
                .then(
                    function (response) {
                        console.log('budget updated successfully');
                        self.successMessage='budget updated successfully';
                        self.errorMessage='';
                        self.done=true;
                        $scope.MyForm.$setPristine();
                    },
                    function (errResponse) {
                        console.log('Error while updating Budget');
                        self.errorMessage='Error while updating Budget';
                        self.successMessage='';

                    }
                );

        }

        function removeBudgets(id) {
            console.log('About to remove Budget with id: '+id);
            BudgetsService.removeBudget(id)
                .then(
                    function () {
                        console.log('Budget '+id+' removed successfully');
                    },
                    function (errResponse) {
                        console.error('Error while removing budget '+id+' , Error: '+errResponse.data);
                    }

                );
        }

        function getAllBudgets() {
            return BudgetsService.getAllBudget();
            
        }

        function editBudgets(id) {
            self.successMessage='';
            self.errorMessage='';
            BudgetsService.getBudget(id).then(
                function (budget) {
                    self.budget=budget;
                },
                function (errResponse) {
                    console.error('Error while removing budget ' +id+' ,Error : '+errResponse.data);
                }
            );
        }

        function reset() {
            self.successMessage='';
            self.errorMessage='';
            self.budget={};
            $scope.MyForm.$setPristine();
        }

    }]);