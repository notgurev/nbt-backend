import React, { useState } from "react";
import { useCombobox } from "downshift";
import {
  Box,
  IconButton,
  Input,
  Button,
  InputGroup,
  InputRightElement,
  List,
  ListItem,
} from "@chakra-ui/react";
import { ArrowDownIcon, ArrowUpIcon } from "@chakra-ui/icons";

export const Combobox = ({ items, listMaxHeight = "200px", ...props }) => {
  const [inputItems, setInputItems] = useState(items);
  const {
    isOpen,
    getToggleButtonProps,
    getMenuProps,
    getLabelProps,
    getInputProps,
    getComboboxProps,
    highlightedIndex,
    getItemProps,
  } = useCombobox({
    items: inputItems,
    onInputValueChange: ({ inputValue }) => {
      setInputItems(
        items.filter((item) =>
          item.toLowerCase().startsWith(inputValue.toLowerCase())
        )
      );
    },
  });

  return (
    <Box {...props}>
      <InputGroup {...getComboboxProps()} lineHeight="shorter">
        <Input {...getInputProps()} />
        <InputRightElement>
          <IconButton
            {...getToggleButtonProps()}
            aria-label="toggle button"
            variant="ghost"
            isRound
            size="sm"
            icon={isOpen ? <ArrowUpIcon /> : <ArrowDownIcon />}
          />
        </InputRightElement>
      </InputGroup>
      <List
        {...getMenuProps()}
        bgColor="white"
        borderRadius="3px"
        boxShadow="md"
        maxHeight={listMaxHeight}
        overflowY="auto"
        marginTop={2}
      >
        {isOpen &&
          inputItems.map((item, index) => (
            <ListItem
              key={`${item}${index}`}
              {...getItemProps({ item, index })}
              bgColor={index === highlightedIndex ? 'gray.100' : ''}
              _hover={{ bgColor: 'gray.50' }}
              padding={[1, 2]}
            >
              {item}
            </ListItem>
          ))}
      </List>
    </Box>
  );
};
