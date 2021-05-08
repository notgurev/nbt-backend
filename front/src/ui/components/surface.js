import React from "react";
import { Box, chakra } from "@chakra-ui/react";
import { css } from "@emotion/react";

const SurfaceComponent = ({ children, ...props }) => (
  <Box
    css={css`
      border-radius: 10px;
      border: 1px solid var(--chakra-colors-gray-200);
      padding: var(--chakra-space-2);
    `}
    {...props}
  >
    {children}
  </Box>
);

export const Surface = chakra(SurfaceComponent);
