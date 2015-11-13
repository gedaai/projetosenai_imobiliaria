'use strict';

angular.module('imobiliaria', [
    'ui.router',
    'ui.bootstrap',
    'rails',
    'flow'
]).config(function ($urlRouterProvider,RailsResourceProvider, railsSerializerProvider) {
    RailsResourceProvider.rootWrapping(false);
    railsSerializerProvider.underscore(angular.identity).camelize(angular.identity);
}).constant('API_URL', 'api/');