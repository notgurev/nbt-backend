import React, { useState } from "react";
import { Box, Flex } from "@chakra-ui/react";
import { Map, YMaps } from "react-yandex-maps";
import { ControlPanel } from "./components/control-panel";
import { FieldsList } from "../../features/field/components/fields-list";

export const HomePage = () => {
  const [fieldsOpen, isFieldsOpen] = useState(false);

  return (
    <YMaps>
      <Flex direction="column" height="100vh">
        <Box flexGrow="1">
          <Map
            defaultState={{ center: [55.751574, 37.573856], zoom: 9 }}
            width="100%"
            height="100%"
          />
        </Box>
        <ControlPanel padding={2} onFieldsToggle={(val) => isFieldsOpen(val)} />
        <FieldsList position="absolute" zIndex="100" height="100%"  />
      </Flex>
    </YMaps>
  );
};

export default HomePage;
