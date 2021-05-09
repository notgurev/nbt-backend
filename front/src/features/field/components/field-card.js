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
      <Flex direction="column">
        <Box height="70vh" width="100%">
          <Map
            defaultState={{ bounds: polygon[0], zoom: 10 }}
            width="100%"
            height="100%"
          />
        </Box>
        <Box padding={2}>
          <FieldInfo fieldId={fieldId} />
        </Box>
      </Flex>
    </YMaps>
  );
};
