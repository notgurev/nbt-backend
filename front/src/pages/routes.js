import React, { Suspense } from 'react';
import {
  Switch,
  Route,
} from 'react-router-dom';

const UserFieldsPage = React.lazy(() => import('./fields/fields'));
const FieldInputPage = React.lazy(() => import('./field-input/field-input-page'));
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
    path: '/',
    component: withSuspense(UserFieldsPage),
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