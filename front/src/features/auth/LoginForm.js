import {
    Button,
    chakra, Flex,
    FormControl,
    FormLabel,
    IconButton,
    Input, InputGroup,
    InputRightElement,
    Stack,
    useDisclosure
} from '@chakra-ui/react'
import * as React from 'react'
import {useState} from "react";
import {HiEye, HiEyeOff} from "react-icons/hi";
import ReactRouterDOM from "react-dom";
import { Redirect, Route, Switch } from "react-router";



export const LoginForm = (props) => {
    const [ username, setUserName ] = useState('');
    const [ password, setPassword ] = useState('');
    const { isOpen, onToggle } = useDisclosure()
    const inputRef = React.useRef(null)
    const axios = require('axios')
    // const Redirect = ReactRouterDOM.Redirect;


    const setLogin = (event) => {
        setUserName(event.target.value);
    }

    const setUserPassword = (event) => {
        setPassword(event.target.value);
    }

    const signInHandler = () => {
        const data = {
            username,
            password
        };

        // console.log(data, 'data')

        axios.post("http://localhost:8080/api/auth/signin", data).then(response => {
            if (response.data.accessToken) {
                localStorage.setItem('user', JSON.stringify(response.data));

            }
            return <Redirect to="/field_input" />;
            console.log(response.data);
        })
    }
    const signUpHandler = () => {
        const data = {
            username,
            password
        };

        // console.log(data, 'data')

        axios.post("http://localhost:8080/api/auth/signup", data).then(response => {
            if (response.data.accessToken) {
                localStorage.setItem('user', JSON.stringify(response.data));

            }
            // console.log(response.data);
            return <Redirect to="/field_input" />;

        })
    }
    const onClickReveal = () => {
        onToggle()
        const input = inputRef.current

        if (input) {
            input.focus({
                preventScroll: true,
            })
            const length = input.value.length * 2
            requestAnimationFrame(() => {
                input.setSelectionRange(length, length)
            })
        }
    }



    return (
        <chakra.form
            onSubmit={(e) => {
                e.preventDefault() // your login logic here
            }}
            {...props}
        >
            <Stack spacing="6">
                <FormControl id="email">
                    <FormLabel>Email address or mobile phone</FormLabel>
                    <Input name="email" type="email" autoComplete="email" required  value={username} onChange={setLogin}/>
                </FormControl>
                <FormControl id="password">
                <Flex justify="space-between">
                    <FormLabel>Password</FormLabel>
                </Flex>
                    <InputGroup>
                        <InputRightElement>
                            <IconButton
                                bg="transparent !important"
                                variant="ghost"
                                aria-label={isOpen ? 'Mask password' : 'Reveal password'}
                                icon={isOpen ? <HiEyeOff /> : <HiEye />}
                                onClick={onClickReveal}
                            />
                        </InputRightElement>
                        <Input name="password" type={isOpen ? 'text' : 'password'} autoComplete="password" required  value={password} onChange={setUserPassword}/>
                    </InputGroup>
                </FormControl>

                <Button type="submit" colorScheme="blue" size="lg" fontSize="md" onClick={signInHandler}>
                    Sign in
                </Button>
                <Button type="submit" colorScheme="blue" size="lg" fontSize="md" onClick={signUpHandler}>
                    Sign up
                </Button>
            </Stack>
        </chakra.form>
    )
}
