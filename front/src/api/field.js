export const sendField = data => fetch('/api/cropFields', {
  method: 'POST',
  body: JSON.stringify(data),
});