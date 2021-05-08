import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  entities: {
    fields: {
      byId: {},
      allIds: [],
    },
  },
};

const fieldsSlice = createSlice({
  name: 'fields',
  initialState,
  reducers: {

  }
});


export const fieldsReducer = fieldsSlice.reducer;