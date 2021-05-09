import React, { useCallback, useState } from "react";
import { MapInput } from "./map-input";
import { Stepper } from "../../../ui/components/stepper";
import { Box, Flex, IconButton } from "@chakra-ui/react";
import { FieldInfoInput } from "./field-info-input";
import { useForm } from "react-hook-form";
import { useDispatch } from "react-redux";
import { CheckCircleIcon } from "@chakra-ui/icons";
import { SoilInfoInput } from "./soil-info-input";
import { EnvironmentPropertiesInput } from "./environment-properties-input";

const screens = [
  (props) => <MapInput {...props} />,
  (props) => <FieldInfoInput  {...props} />,
  (props) => <SoilInfoInput {...props} />,
  (props) => <EnvironmentPropertiesInput {...props} />
];

const renderScreen = (step, props) => screens[step - 1](props);

const defaultValues = {
  cultureName: "",
  previousCulture: "",
  soil: {
    type: "",
  },
};

export const SendFieldForm = () => {
  const [screen, setScreen] = useState(1);
  const { handleSubmit, register, control, setValue, watch } = useForm({
    defaultValues,
  });
  const dispatch = useDispatch();
  const onSubmit = useCallback(
    (data) => {
      console.dir(data);
    },
    [dispatch, screen]
  );

  const onStepChange = (val) => {
    setScreen(val);
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <Flex direction="column" height="100vh">
        <Box flexGrow="1" overflowY="auto">
          {renderScreen(screen, { register, setValue, control, watch })}
        </Box>
        <Stepper
          initialStep={1}
          maxSteps={screens.length}
          onChange={onStepChange}
          padding={[2, 4]}
        />
        <Box position="absolute" bottom="65px" width="100%" padding={[0, 4]}>
          <Box textAlign="center">
            <IconButton
              type="submit"
              colorScheme="teal"
              aria-label="finish"
              borderRadius="50%"
              icon={<CheckCircleIcon />}
            />
          </Box>
        </Box>
      </Flex>
    </form>
  );
};
