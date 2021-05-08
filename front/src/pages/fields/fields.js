import React from "react";
import { FieldCard } from "../../features/field/components/field-card";
import { Box } from "@chakra-ui/react";

export const FieldsPage = () => {
  return (
    <Box padding={2} minHeight="100vh">
      <FieldCard fieldId="example" height="100%" />
    </Box>
  );
};

export default FieldsPage;
