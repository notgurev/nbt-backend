import React, { useEffect } from "react";
import "react-date-picker/dist/DatePicker.css";
import {
  FormControl,
  FormLabel,
  Input,
  InputGroup,
  InputRightElement,
  Stack,
  Table,
  TableCaption,
  Tbody,
  Td,
  Text,
  Th,
  Thead,
  Tr,
} from "@chakra-ui/react";
import { Combobox } from "../../../ui/components/combobox";

const soilTypes = [
  "чернозем",
  "бурозем",
  "дерново-подзолистая",
  "оглеенная",
  "дерновая",
  "луговая",
  "пойменная",
  "глеевая",
  "болотная",
  "торфяная",
  "солончаковая",
  "солонцовая",
  "бурая",
  "краснозем",
  "подзолистая",
  "рендзина",
  "альпийская дерновая",
  "ювенильная",
  "антропогенная",
  "подводная",
];

const NPKTable = ({ register, ...props }) => (
  <Table>
    <TableCaption>Содержание азота, фосфора и калия</TableCaption>
    <Thead>
      <Tr>
        <Th>Азот</Th>
        <Th>Фосфор</Th>
        <Th>Калий</Th>
      </Tr>
    </Thead>
    <Tbody>
      <Tr>
        <Td>
          <Input min={0} max={100} step={0.01} {...register("soil.nitrogen")} />
        </Td>
        <Td>
          <Input
            min={0}
            max={100}
            step={0.01}
            {...register("soil.phosphorus")}
          />
        </Td>
        <Td>
          <Input
            min={0}
            max={100}
            step={0.01}
            {...register("soil.potassium")}
          />
        </Td>
      </Tr>
    </Tbody>
  </Table>
);

export const SoilInfoInput = ({ register, setValue, watch, control, ...props }) => {
  const soilType = watch("soil.type");

  useEffect(() => {
    register("soil.type");
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
      {...props}
    >
      <FormControl>
        <Combobox
          items={soilTypes}
          defaultValue={soilType}
          onChange={(val) => setValue("soil.type", val)}
          label={(labelProps) => (
            <FormLabel {...labelProps}>Тип почвы</FormLabel>
          )}
        />
      </FormControl>
      <FormControl>
        <FormLabel>Сорт (в процентах)</FormLabel>
        <InputGroup>
          <Input
            type="number"
            min={0}
            max={100}
            step={0.01}
            {...register("soil.wet")}
          />
          <InputRightElement pointerEvents="none">
            <Text>%</Text>
          </InputRightElement>
        </InputGroup>
      </FormControl>
      <FormControl>
        <FormLabel>Максимальная глубина корневой системы ( в см.)</FormLabel>
        <InputGroup>
          <Input type="number" {...register("soil.deepOfRootSystem")} />
          <InputRightElement pointerEvents="none">
            <Text>см</Text>
          </InputRightElement>
        </InputGroup>
      </FormControl>
      <NPKTable register={register} />
      <FormControl>
        <FormLabel>Температура почвы</FormLabel>
        <InputGroup>
          <Input type="number" {...register("soil.earthTemperature")} />
          <InputRightElement pointerEvents="none">
            <Text>℃</Text>
          </InputRightElement>
        </InputGroup>
      </FormControl>
    </Stack>
  );
};
