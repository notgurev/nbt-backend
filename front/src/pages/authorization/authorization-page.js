import React from "react";
import {Box, useColorModeValue} from "@chakra-ui/react";
import {LoginForm} from "../../features/auth/LoginForm";
import {Card} from "../../features/auth/Card";

export const AuthorizationPage = () => (
    <Box
        bg={useColorModeValue('gray.50', 'inherit')}
        minH="100vh"
        py="12"
        px={{
            base: '4',
            lg: '8',
        }}
    >
        <Box maxW="400" mx="auto">
            <Card>
                <LoginForm />
            </Card>
        </Box>
    </Box>
);

export default AuthorizationPage;