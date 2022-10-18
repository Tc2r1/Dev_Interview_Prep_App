import React from 'react';
import {StyleSheet, Text, View, Linking} from 'react-native';
import {Divider} from 'react-native-elements';
import PieChart from 'react-native-pie-chart';
import {Button} from 'react-native-elements';
import {useStateValue} from '../stateProvider';
import Questions from '../questions.json';
import AsyncStorage from '@react-native-async-storage/async-storage';

let storeData = async (user, score) => {
  let currentLeaderboard = await AsyncStorage.getItem('leaderBoard');
  let newData = {
    name: user,
    score: score,
  };
  if (currentLeaderboard == null) {
    currentLeaderboard = [];
    currentLeaderboard.push(newData);
  } else {
    currentLeaderboard = JSON.parse(currentLeaderboard);
    currentLeaderboard.push(newData);
  }
  await AsyncStorage.setItem(
    'leaderBoard',
    JSON.stringify(currentLeaderboard),
  ).catch(() => {
    console.log('error saving');
  });
};
const CongratScreen = ({navigation}) => {
  const [{user, score}] = useStateValue();
  storeData(user, score);
  const widthAndHeight = 150;
  const series = [score, Questions.questions.length - score];
  const sliceColor = ['#00FF00'];
  return (
    <View style={styles.cogratsScreen}>
      <Text style={styles.congratsText}>
        Congratulations {user}, You've scored {score} points
      </Text>
      <PieChart
        widthAndHeight={widthAndHeight}
        series={series}
        sliceColor={sliceColor}
        doughnut={true}
        coverRadius={0.7}
        coverFill={'#FFF'}
      />
      <Text style={styles.scoreStyle}>{score}</Text>
      <Divider width={100} />
      <Button
        title="View Leaderboard"
        type="solid"
        onPress={() => {
          navigation.navigate('leaderBoardScreen');
        }}
      />
      <Text style={styles.congratsText}>Liked it?</Text>
      <Button
        title="Give a ⭐ on github"
        type="outline"
        onPress={() => {
          Linking.openURL(
            'https://www.github.com/vivekkj123/quiz-app-react-native',
          );
        }}
      />
    </View>
  );
};

export default CongratScreen;

const styles = StyleSheet.create({
  cogratsScreen: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  congratsText: {
    fontSize: 26,
    textAlign: 'center',
    marginVertical: 20,
  },
  scoreStyle: {
    position: 'relative',
    bottom: 105,
    fontSize: 45,
    fontWeight: '800',
  },
});
