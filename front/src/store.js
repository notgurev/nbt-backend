import { configureStore } from "@reduxjs/toolkit";
import { fieldsReducer } from "./features/field";


export default configureStore({
  reducer: {
    fields: fieldsReducer,
  },
});