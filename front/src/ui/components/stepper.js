import React, { useCallback, useState } from "react";
import PropTypes from 'prop-types';
import { Button, Flex, Text, ChakraComponent } from "@chakra-ui/react";


/**
 *
 * @param maxSteps
 * @param initialStep
 * @param onChange
 * @param props
 * @returns {ChakraComponent}
 * @constructor
 */
export const Stepper = ({ maxSteps, initialStep, onChange, ...props }) => {
  const [step, setStep] = useState(initialStep);

  const prevButtonCallback = useCallback(() => {
    if (step > 1) {
      setStep(step - 1);
      onChange(step - 1);
    }
  }, []);

  const nextButtonCallback = useCallback(() => {
    if (step < maxSteps) {
      setStep(step + 1);
      onChange(step + 1);
    }
  }, []);

  return (
    <Flex justify="space-between" align="center" {...props}>
      <Button isDisabled={initialStep >= maxSteps} onClick={prevButtonCallback}>Назад</Button>
      <Text as="span">{initialStep} / {maxSteps}</Text>
      <Button isDisabled={initialStep <= 1} onClick={nextButtonCallback}>Вперед</Button>
    </Flex>
  );
};

Stepper.propTypes = {
  maxSteps: PropTypes.number,
  initialStep: PropTypes.number,
  onChange: PropTypes.func,
};