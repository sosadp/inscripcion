var app = angular.module('gastosPerApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/ins',
    ALUMNOS_SERVICE_API : 'http://localhost:8080/ins/api/concepts/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home',{
                url:'/home',
                templateUrl:'partials/home'
            })

            .state('alumnos', {
                url: '/alumnos',
                templateUrl: 'partials/alumnos',
                controller:'AlumnosController',
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
        $urlRouterProvider.otherwise('/home');
    }]);

