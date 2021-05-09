import React from "react";
import { Box, Flex } from "@chakra-ui/react";
import { Map, YMaps } from "react-yandex-maps";
import { ControlPanel } from "./components/control-panel";

export const HomePage = () => {
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
        <ControlPanel padding={2} />
      </Flex>
    </YMaps>
  );
};

export default HomePage;
