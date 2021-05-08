import React from "react";
import { FieldInfo } from "./field-info";
import { Surface } from "../../../ui/components/surface";
import { Map, withYMaps } from "react-yandex-maps";
import { useSelector } from "react-redux";

const FieldCardComponent = ({ fieldId, ymaps }) => {
  const polygon = useSelector(
    (state) => state.fields.entities.fields.byId[fieldId].polygon
  );

  return (
    <Surface>
      <Map
        ymaps={ymaps}
        defaultState={{ bounds: polygon, zoom: 10 }}
        width="100%"
        height="70%"
      />
      <FieldInfo fieldId={fieldId} />
    </Surface>
  );
};

export const FieldCard = withYMaps(FieldCardComponent);
