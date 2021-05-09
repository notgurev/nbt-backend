import React, { useCallback, useState } from "react";
import { Button, Center, IconButton, Stack } from "@chakra-ui/react";
import { ChevronDownIcon, ChevronUpIcon, PlusSquareIcon } from "@chakra-ui/icons";

export const ControlPanel = ({ onFieldsToggle, ...props }) => {
  const [fieldsOpen, isFieldsOpen] = useState(false);

  const fieldButtonCallback = useCallback(() => {
    isFieldsOpen(state => !state);
    onFieldsToggle(fieldsOpen);
  }, [fieldsOpen]);

  return (
    <Center {...props}>
      <Stack direction="row" align="center" spacing={5}>
        <Button colorScheme="teal" variant="ghost" onClick={fieldButtonCallback}>
          Поля {fieldsOpen ? <ChevronDownIcon ml={1} /> : <ChevronUpIcon ml={1} /> }
        </Button>
        <IconButton
          colorScheme="teal"
          aria-label="new field"
          borderRadius="50%"
          icon={<PlusSquareIcon />}
        />
        <Button colorScheme="teal" variant="ghost">
          Профиль
        </Button>
      </Stack>
    </Center>
  );
};