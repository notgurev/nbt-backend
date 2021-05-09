import React, { useEffect } from "react";
import "react-date-picker/dist/DatePicker.css";
import {
  FormControl,
  FormLabel,
  Input,
  InputGroup,
  InputRightElement,
  Stack,
  Text,
} from "@chakra-ui/react";

export const EnvironmentPropertiesInput = ({
  register,
  setValue,
  watch,
  control,
  ...props
}) => {
  return (
    <Stack
      direction="column"
      spacing={6}
      fontSize="md"
      align="stretch"
      margin={2}
      lineHeight="short"
      {...props}
    >
      <FormControl>
        <FormLabel>Наиболее благоприятный pH</FormLabel>
        <Input type="number" {...register("culture.ph")} />
      </FormControl>
      <FormControl>
        <FormLabel>Средняя толщина снежного покрова</FormLabel>
        <InputGroup>
          <Input type="number" {...register("snowCover")} />
          <InputRightElement pointerEvents="none">
            <Text>см</Text>
          </InputRightElement>
        </InputGroup>
      </FormControl>
      <FormControl>
        <FormLabel>Урожайность за 5 лет</FormLabel>
        <InputGroup>
          <Input type="number" {...register("yield")} />
          <InputRightElement pointerEvents="none">
            <Text>т/га</Text>
          </InputRightElement>
        </InputGroup>
      </FormControl>
    </Stack>
  );
};