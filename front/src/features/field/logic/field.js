import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import { sendField } from "../../../api/field";

const initialState = {
  entities: {
    fields: {
      byId: {
        example: {
          cultureName: 'Кукуруза',
          polygon: [
            // Координаты внешнего контура.
            [[-80, 60], [-90, 50], [-60, 40], [-80, 60]],
          ],
          previousCulture: 'Пшеница',
          culture: {
            name: 'Добрыня',
            sowingDate: new Date().toDateString(),
            collectionDate: new Date().toDateString(),
          },
          height: 1.5,
        }
      },
      allIds: ['example'],
    },
  },
};

const sendFieldData = createAsyncThunk(
  `fields/sendFieldData`,
  async (fieldData) => {
      const response = await sendField(fieldData);
      if (response.ok) {
        return fieldData;
      }
      throw new Error('Request error');
  }
);

const fieldsSlice = createSlice({
  name: 'fields',
  initialState,
  reducers: {

  },
  extraReducers: builder => {
    builder.addCase(sendFieldData.fulfilled, (state, { payload }) => {

    })
  }
});


export const fieldsReducer = fieldsSlice.reducer;