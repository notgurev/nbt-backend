import React, { useEffect, useState } from "react";
import "react-date-picker/dist/DatePicker.css";
import { chakra, FormControl, FormLabel, Input, Stack } from "@chakra-ui/react";
import { Combobox } from "../../../ui/components/combobox";
import DatePicker from "react-date-picker";
import { useForm, Controller } from "react-hook-form";
import { shallowEqual, useSelector } from "react-redux";

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

export const FieldInfoInput = ({ register, setValue, watch, control }) => {
  const cultureValue = watch("culture");
  const previousCultureValue = watch("previousCulture");

  useEffect(() => {
    register("culture");
    register("previousCulture");
  }, [register]);

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
          defaultValue={cultureValue}
          onChange={(val) => setValue("culture", val)}
          label={(labelProps) => (
            <FormLabel {...labelProps}>Культура</FormLabel>
          )}
        />
      </FormControl>
      <FormControl>
        <FormLabel>Сорт</FormLabel>
        <Input {...register("grade")} />
      </FormControl>
      <FormControl>
        <Combobox
          items={items}
          defaultValue={previousCultureValue}
          onChange={(val) => setValue("previousCulture", val)}
          label={(labelProps) => (
            <FormLabel {...labelProps}>Предшественник</FormLabel>
          )}
        />
      </FormControl>
      <FormControl>
        <FormLabel>Дата сева</FormLabel>
        <Controller
          name="sowingDate"
          control={control}
          render={({ field: { onChange, value } }) => (
            <ChakraDatePicker value={value} onChange={onChange} />
          )}
        />
      </FormControl>
      <FormControl>
        <FormLabel>Дата сборки предшественника</FormLabel>
        <Controller
          name="harvestingDate"
          control={control}
          // defaultValue={formDa}
          render={({ field: { value, onChange } }) => (
            <ChakraDatePicker value={value} onChange={onChange} />
          )}
        />
      </FormControl>
    </Stack>
  );
};
