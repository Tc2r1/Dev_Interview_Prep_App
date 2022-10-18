export const initialState = {
  user: null,
  score: 0,
};

const reducer = (state, action) => {
  console.log(action);
  switch (action.type) {
    case 'SET_USER':
      return {
        ...state,
        user: action.user,
      };
    case 'UPDATE_SCORE':
      return {
        ...state,
        score: state.score + action.score,
      };
    default:
      return state;
  }
};

export default reducer;
