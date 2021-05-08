import React, { useCallback, useState } from "react";
import { MapInput } from "./map-input";
import { Stepper } from "../../../ui/components/stepper";
import { Box, Flex } from "@chakra-ui/react";
import { FieldInfoInput } from "./field-info-input";
import { useForm } from "react-hook-form";
import { useDispatch, useSelector } from "react-redux";

const screens = [
  (props) => <MapInput {...props} />,
  (props) => <FieldInfoInput {...props} />,
];

const renderScreen = (step, props) => screens[step - 1](props);

const defaultValues = {
  culture: '',
  previousCulture: '',
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
    handleSubmit(onSubmit)();
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <Flex direction="column" height="100vh">
        <Box flexGrow="1">
          {renderScreen(screen, { register, setValue, control, watch })}
        </Box>
        <Stepper
          initialStep={1}
          maxSteps={screens.length}
          onChange={onStepChange}
          padding={[2, 4]}
        />
      </Flex>
    </form>
  );
};
