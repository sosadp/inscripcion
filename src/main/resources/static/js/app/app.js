var app = angular.module('insApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/ins',
    ALUMNOS_SERVICE_API : 'http://localhost:8080/ins/api/alumno/'

});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('index',{
                url:'/index',
                templateUrl:'partials/index'
            })

            .stage('login',{
                url:'/login',
                templateUrl:'partials/login'
            })

            .state('alumno', {
                url: '/alumno',
                templateUrl: 'partials/alumno',
                controller:'AlumnoController',
                controllerAs:'ctrl',
                resolve: {
                    concepts: function ($q, ConceptsService) {
                        console.log('Load all alumnos');
                        var deferred = $q.defer();
                        AlumnosService.loadAllAlumnos().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            })
        $urlRouterProvider.otherwise('/login');
    }]);

