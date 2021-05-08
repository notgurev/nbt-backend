import React, { useState } from "react";
import { MapInput } from "./map-input";
import { Stepper } from "../../../ui/components/stepper";
import { Box, Flex } from "@chakra-ui/react";
import { FieldInfoInput } from "./field-info-input";

const screens = [
  props => (
    <MapInput {...props} />
  ),
  props => (
    <FieldInfoInput />
  ),
];

const renderScreen = (step, props) => screens[step - 1](props);

export const SendFieldForm = () => {
  const [screen, setScreen] = useState(1);

  return (
    <form>
      <Flex direction="column" height="100vh">
        <Box flexGrow="1">
          {renderScreen(screen)}
        </Box>
        <Stepper initialStep={1} maxSteps={screens.length} onChange={val => setScreen(val)} padding={[2, 4]} />
      </Flex>
    </form>
  );
};
