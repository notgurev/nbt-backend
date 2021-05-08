import React from "react";
import { MapInput } from "./map-input";
import { Stepper } from "../../../ui/components/stepper";
import { Box, Flex, FormControl } from "@chakra-ui/react";

export const SendFieldForm = () => {
  return (
    <FormControl>
      <Flex direction="column" height="100vh">
        <Box flexGrow="1">
          <MapInput />
        </Box>
        <Stepper initialStep={1} maxSteps={5} padding={[2, 4]} />
      </Flex>
    </FormControl>
  );
};