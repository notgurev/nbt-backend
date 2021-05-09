import React, { useState } from "react";
import { useCombobox } from "downshift";
import {
  Box,
  IconButton,
  Input,
  InputGroup,
  InputRightElement,
  List,
  ListItem,
} from "@chakra-ui/react";
import { ArrowDownIcon, ArrowUpIcon } from "@chakra-ui/icons";

export const Combobox = ({
  items,
  listMaxHeight = "200px",
  label,
  defaultValue = "",
  onChange,
  inputProps,
  ...props
}) => {
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
    defaultInputValue: defaultValue,
    onInputValueChange: ({ inputValue }) => {
      onChange(inputValue);
      setInputItems(
        items.filter((item) =>
          item.toLowerCase().startsWith(inputValue.toLowerCase())
        )
      );
    },
  });

  return (
    <Box {...props}>
      {label(getLabelProps())}
      <InputGroup {...getComboboxProps()} lineHeight="shorter">
        <Input
          {...getInputProps()}
          {...inputProps}
        />
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
        position="absolute"
        zIndex="100"
        width="100%"
        marginTop={2}
      >
        {isOpen &&
          inputItems.map((item, index) => (
            <ListItem
              key={`${item}${index}`}
              {...getItemProps({ item, index })}
              bgColor={index === highlightedIndex ? "gray.100" : ""}
              _hover={{ bgColor: "gray.50" }}
              padding={[1, 2]}
            >
              {item}
            </ListItem>
          ))}
      </List>
    </Box>
  );
};
