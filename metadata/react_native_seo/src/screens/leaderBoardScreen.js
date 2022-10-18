import {StyleSheet, Text, View} from 'react-native';
import React, {useEffect, useState} from 'react';
import Leaderboard from 'react-native-leaderboard';
import AsyncStorage from '@react-native-async-storage/async-storage';

let getData = async setData => {
  let LeaderboardData = await AsyncStorage.getItem('leaderBoard');
  setData(JSON.parse(LeaderboardData));
};
const LeaderBoardScreen = () => {
  const [Data, setData] = useState([]);

  useEffect(() => {
    getData(setData);
  }, [setData]);
  // console.log(Data);
  return (
    <View>
      <Text style={styles.HeadLeaderboard}>LeaderBoard 📊</Text>
      <Leaderboard data={Data} sortBy="score" labelBy="name" />
    </View>
  );
};

export default LeaderBoardScreen;

const styles = StyleSheet.create({
  HeadLeaderboard: {
    fontSize: 25,
    textAlign: 'center',
    padding: 20,
  },
});
