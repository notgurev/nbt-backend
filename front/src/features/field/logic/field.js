import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  entities: {
    fields: {
      byId: {
        example: {
          name: 'Кукуруза',
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