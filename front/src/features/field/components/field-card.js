import React from "react";
import { FieldInfo } from "./field-info";
import { Surface } from "../../../ui/components/surface";
import { Map, YMaps } from "react-yandex-maps";
import { useSelector } from "react-redux";
import { Box, Flex } from "@chakra-ui/react";

export const FieldCard = ({ fieldId, ...props }) => {
  const polygon = useSelector(
    (state) => state.fields.entities.fields.byId[fieldId].polygon
  );

  return (
    <YMaps>
      <Surface {...props}>
        <Flex direction="column" height="100%">
          <Box height="70vh">
            <Map
              defaultState={{ center: [55.751574, 37.573856], zoom: 9 }}
              // defaultState={{ bounds: polygon, zoom: 10 }}
              width="100%"
              height="100%"
            />
          </Box>
          <FieldInfo fieldId={fieldId} />
        </Flex>
      </Surface>
    </YMaps>
  );
};
