import React from "react";
import {Map} from "react-yandex-maps/dist/development/react-yandex-maps";

export const MapInput = () => (
  <Map defaultState={{ center: [55.751574, 37.573856], zoom: 9 }} width="100%" height="50vh" />
);