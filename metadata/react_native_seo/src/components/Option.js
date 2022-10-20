import React from 'react';
import {StyleSheet, Text, View, TouchableOpacity} from 'react-native';
import Questions from '../questions.json';
import {useStateValue} from '../stateProvider';

const Option = props => {
  const [{score}, dispatch] = useStateValue();
  const updateScore = Score => {
    dispatch({
      type: 'UPDATE_SCORE',
      score: Score,
    });
  };
  console.log(score);
  let correctAnswerIdx = Questions.questions[props.qnIndex].correctIndex;
  // let handleValidation = () => {
  //   if (props.optionIdx === correctAnswerIdx) {
  //     console.log('Correct Answer');
  //     setOptioncolor({borderColor: 'green'});
  //   } else {
  //     console.log('Wrong Answer');
  //     setOptioncolor({borderColor: 'red'});
  //   }
  // };
  return (
    <TouchableOpacity
      onPress={() => {
        props.optionIdx === correctAnswerIdx ? updateScore(1) : updateScore(0);
        if (props.qnIndex + 1 >= Questions.questions.length) {
          console.log('End of Quiz');
          props.navigation.navigate('CongratsScreen');
        } else {
          props.navigation.navigate('QuestionScreen', {
            index: props.qnIndex + 1,
          });
        }
      }}>
      <View style={[styles.Option]}>
        <Text style={styles.OptionText}>{props.value}</Text>
      </View>
    </TouchableOpacity>
  );
};

export default Option;

const styles = StyleSheet.create({
  Option: {
    borderColor: 'black',
    borderWidth: 3,
    margin: 40,
    marginBottom: 3,
    borderRadius: 25,
    height: 95,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#EDECEC',
  },
  OptionText: {
    fontSize: 26,
  },
});
