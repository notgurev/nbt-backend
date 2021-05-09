import React, { Suspense } from 'react';
import {
  Switch,
  Route,
} from 'react-router-dom';

const UserFieldsPage = React.lazy(() => import('./fields/fields'));
const FieldInputPage = React.lazy(() => import('./field-input/field-input-page'));
const HomePage = React.lazy(() => import('./home/home'));
const AuthorizationPage = React.lazy(() => import('./authorization/authorization-page'));

const withSuspense = (Component) => (props) => (
  <Suspense fallback={<div>Загрузка</div>}>
    <Component {...props} />
  </Suspense>
);

const routes = [
  {
    path: '/field_input',
    component: withSuspense(FieldInputPage),
  },
  {
    path: '/auth',
    component: withSuspense(AuthorizationPage),
  },
  {
    path: '/fields',
    component: withSuspense(UserFieldsPage),
  },
  {
    path: '/',
    component: withSuspense(HomePage),
  },
];

const RouteWithSubRoutes = (route) => (
  <Route
    path={route.path}
    render={(props) => (
      // pass the sub-routes down to keep nesting
      <route.component {...props} routes={route.routes} />
    )}
  />
);

export const Routes = () => (
  <Switch>
    {routes.map((route, i) => (
      <RouteWithSubRoutes key={i} {...route} />
    ))}
  </Switch>
);