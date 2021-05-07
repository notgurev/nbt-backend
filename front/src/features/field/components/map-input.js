import React, { useState, useCallback } from "react";
import { Button, Map, SearchControl, Polygon, withYMaps } from "react-yandex-maps/dist/development/react-yandex-maps";

const MapInputTemplate = ({ymaps}) => {
  const [polygonEmpty, isPolygonEmpty] = useState(true);
  const [polygon, setPolygon] = useState(null);
  const polygonRef = useCallback(polygon => {
    if (!polygon) return;
    setPolygon(polygon);
    polygon.editor.startDrawing();

    polygon.events.add('geometrychange', () => {
      const coordinates = polygon.geometry.getCoordinates();
      if (!coordinates.length || !coordinates[0].length) {
        isPolygonEmpty(true);
        return;
      }
      isPolygonEmpty(false);
    });
  }, []);

  const buttonRef = useCallback(button => {
    if (!button) return;
    button.events.add('click', () => {
      if (polygon) {
        polygon.geometry.setCoordinates([]);
        polygon.editor.startDrawing();
      }
    });
  }, [polygon]);

  return (
    <Map
      defaultState={{center: [55.751574, 37.573856], zoom: 9}}
      width="100%"
      height="100vh"
      modules={["geoObject.addon.editor"]}
    >
      {!polygonEmpty && <Button data={{content: 'Удалить поле'}} options={{maxWidth: 128, float: 'left'}} instanceRef={buttonRef}/>}
      <SearchControl options={{float: 'right'}}/>
      <Polygon instanceRef={polygonRef} defaultGeometry={[]}/>
    </Map>
  );
}

export const MapInput = withYMaps(MapInputTemplate, true);