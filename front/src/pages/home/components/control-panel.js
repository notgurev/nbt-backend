import React from "react";
import { Button, Center, IconButton, Stack } from "@chakra-ui/react";
import { ChevronUpIcon, PlusSquareIcon } from "@chakra-ui/icons";

export const ControlPanel = ({ ...props }) => (
  <Center {...props}>
    <Stack direction="row" align="center" spacing={5}>
      <Button colorScheme="teal" variant="ghost">Поля <ChevronUpIcon ml={1} /></Button>
      <IconButton
        colorScheme="teal"
        aria-label="new field"
        borderRadius="50%"
        icon={<PlusSquareIcon />}
      />
      <Button colorScheme="teal" variant="ghost">Профиль</Button>
    </Stack>
  </Center>
);