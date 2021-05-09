import React from "react";
import {
  Box,
  Divider,
  Heading,
  List,
  ListItem,
  Stack,
  Text,
} from "@chakra-ui/react";
import { Surface } from "../../../ui/components/surface";
import { useSelector } from "react-redux";

const ItemValue = ({ children, ...props }) => (
  <Box as="strong" {...props}>
    {children}
  </Box>
);

const dateFormat = new Intl.DateTimeFormat();
const formatDate = dateString => dateFormat.format(Date.parse(dateString));

export const FieldInfo = ({ fieldId }) => {
  const {
    name,
    previousCulture,
    culture: { name: grade, sowingDate, collectionDate },
  } = useSelector((state) => state.fields.entities.fields.byId[fieldId]);

  return (
    <Box>
      <Surface fontSize="md">
        <Stack direction="column" spacing={3}>
          <Heading>Культура 🌽</Heading>
          <Text fontWeight="medium" fontSize="1.2em">
            Здесь растет {name}
          </Text>
          <Divider />
          <Box>
            <Text fontWeight="medium" fontSize="1.2em">
              Сведения о культуре:
            </Text>
            <List marginTop={1}>
              <ListItem>
                Сорт: <ItemValue>{grade}</ItemValue>
              </ListItem>
              <ListItem>Предшественник: <ItemValue>{previousCulture}</ItemValue></ListItem>
              <ListItem>Дата сева: <ItemValue>{formatDate(sowingDate)}</ItemValue></ListItem>
              <ListItem>Дата сборки предшественника: <ItemValue>{formatDate(collectionDate)}</ItemValue></ListItem>
            </List>
          </Box>
        </Stack>
      </Surface>
    </Box>
  );
};
