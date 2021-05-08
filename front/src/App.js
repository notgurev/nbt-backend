import { ChakraProvider } from "@chakra-ui/react";
import { BrowserRouter as Router } from "react-router-dom";
import { YMaps } from "react-yandex-maps/dist/development/react-yandex-maps";
import "./App.css";
import { Provider } from "react-redux";
import store from "./store";
import { Routes } from "./pages/routes";

function App() {
  return (
    <Provider store={store}>
      <ChakraProvider>
        <YMaps query={{ apikey: "1378d282-a125-475d-a207-93a8fff40f80" }}>
          <Router>
            <Routes />
          </Router>
        </YMaps>
      </ChakraProvider>
    </Provider>
  );
}

export default App;
