import React from "react";
import { Heading, List, ListItem, Text } from "@chakra-ui/react";
import { useSelector } from "react-redux";
import { Link } from "react-router-dom";
import { Surface } from "../../../ui/components/surface";

const FieldsListItem = ({ fieldId, index }) => {
  const { cultureName } = useSelector(state => state.entities.fields.byId[fieldId]);

  return (
    <Link to={`/fields/${fieldId}`}>
      <Surface>
        <Heading>Поле {index + 1}</Heading>
        <Text colorScheme="gray.500">Культура: {cultureName}</Text>
      </Surface>
    </Link>
  )
};

export const FieldsList = ({ ...props }) => {
  const fieldIds = useSelector(state => state.fields.entities.fields.allIds);

  return (
    <List {...props}>
      {fieldIds.map((fieldId, index) => (
        <ListItem>
          <FieldsListItem fieldId={fieldId} index={index} />
        </ListItem>
      ))}
    </List>
  )
};