import React from "react";
import { Box, FormControl, FormLabel } from "@chakra-ui/react";
import { Combobox } from "../../../ui/components/combobox";

const items = [
  'пшеница яровая мягкая',
  'пшеница яровая твердая',
  'пшеница озимая',
  'кукуруза',
  'ячмень',
  'овес',
  'свекла',
  'картофель',
  'подсолнух',
  'виноградники',
];

export const FieldInfoInput = () => {
  return (
    <Box>
      <FormControl>
        <FormLabel>Культура</FormLabel>
        <Combobox items={items} fontSize="md" lineHeight="short" />
      </FormControl>
    </Box>
  );
};
