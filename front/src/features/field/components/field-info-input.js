import React, { useState } from "react";
import "react-date-picker/dist/DatePicker.css";
import { chakra, FormControl, FormLabel, Input, Stack } from "@chakra-ui/react";
import { Combobox } from "../../../ui/components/combobox";
import DatePicker from "react-date-picker";

const items = [
  "пшеница яровая мягкая",
  "пшеница яровая твердая",
  "пшеница озимая",
  "кукуруза",
  "ячмень",
  "овес",
  "свекла",
  "картофель",
  "подсолнух",
  "виноградники",
];

const ChakraDatePicker = chakra(DatePicker);

export const FieldInfoInput = () => {
  const [sowingDate, setSowingDate] = useState(new Date());
  const [harvesting, setHarvestingDate] = useState(new Date());

  return (
    <Stack
      direction="column"
      spacing={6}
      fontSize="md"
      align="stretch"
      margin={2}
      lineHeight="short"
    >
      <FormControl>
        <Combobox
          items={items}
          label={(labelProps) => (
            <FormLabel {...labelProps}>Культура</FormLabel>
          )}
        />
      </FormControl>
      <FormControl>
        <FormLabel>Сорт</FormLabel>
        <Input />
      </FormControl>
      <FormControl>
        <Combobox
          items={items}
          label={(labelProps) => (
            <FormLabel {...labelProps}>Предшественник</FormLabel>
          )}
        />
      </FormControl>
      <FormControl>
        <FormLabel>Дата сева</FormLabel>
        <ChakraDatePicker
          value={sowingDate}
          onChange={setSowingDate}
        />
      </FormControl>
      <FormControl>
        <FormLabel>Дата сборки предшественника</FormLabel>
        <ChakraDatePicker
          value={harvesting}
          onChange={setHarvestingDate}
        />
      </FormControl>
    </Stack>
  );
};
