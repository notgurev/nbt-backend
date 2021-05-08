import { FieldInput } from "./pages/field-input/FieldInput";
import { ChakraProvider } from "@chakra-ui/react";
import { YMaps } from "react-yandex-maps/dist/development/react-yandex-maps";
import "./App.css";

function App() {
  return (
    <ChakraProvider>
      <YMaps query={{ apikey: "1378d282-a125-475d-a207-93a8fff40f80" }}>
        <div className="App">
          <div>
            <FieldInput />
          </div>
        </div>
      </YMaps>
    </ChakraProvider>
  );
}

export default App;
