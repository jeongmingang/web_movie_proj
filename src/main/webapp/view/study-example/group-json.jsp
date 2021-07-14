<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="icon" href="data:;base64,iVBORw0KGgo=">	<!-- 파비콘 오류 메세지 해결 -->
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<c:set var="contextPath" value="<%=request.getContextPath() %>" />
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${contextPath}/resources/js/json-groupby/dist/json-groupby.js"></script>
	<script>
	
		/* 방법 1 */

			const songs = [
			    {
			        "name": "The Less I Know the Better",
			        "duration": "0",
			        "listeners": "439958",
			        "mbid": "",
			        "url": "https://www.last.fm/music/Tame+Impala/_/The+Less+I+Know+the+Better",
			        "artist": {
			            "name": "Tame Impala",
			            "mbid": "63aa26c3-d59b-4da4-84ac-716b54f1ef4d",
			            "url": "https://www.last.fm/music/Tame+Impala"
			        },
			        "@attr": {
			            "rank": "0"
			        },
			        "genre": "reggae"
			    },
			    {
			        "name": "Creep",
			        "duration": "239",
			        "listeners": "1647583",
			        "mbid": "d11fcceb-dfc5-4d19-b45d-f4e8f6d3eaa6",
			        "url": "https://www.last.fm/music/Radiohead/_/Creep",
			        "artist": {
			            "name": "Radiohead",
			            "mbid": "a74b1b7f-71a5-4011-9441-d0b5e4122711",
			            "url": "https://www.last.fm/music/Radiohead"
			        },
			        "@attr": {
			            "rank": "1"
			        },
			        "genre": "jazz"
			    },
			    {
			        "name": "Go to Sleep",
			        "duration": "239",
			        "listeners": "16583",
			        "mbid": "d11fcceb-dfc5-4d19-b45d-f4e8f6d3eaa6",
			        "url": "https://www.last.fm/music/Radiohead/_/Go to Sleep",
			        "artist": {
			            "name": "Radiohead",
			            "mbid": "a74b1b7f-71a5-4011-9441-d0b5e4122711",
			            "url": "https://www.last.fm/music/Radiohead"
			        },
			        "@attr": {
			            "rank": "3"
			        },
			        "genre": "jazz"
			    }
			]
		
			//console.log(songs);
		
			const byArtist = songs.reduce((acc, song) => {
			  const artistName = song.artist.name;
			  const match = acc.get(artistName);
			  if (match) {
			    match.songs.push({...song});
			    match.listeners += parseInt(song.listeners);
			  } else {
			    acc.set(artistName, {songs: [{...song}], listeners: +song.listeners});
			  }
			  return acc;
			}, new Map);
		

			console.log(Object.fromEntries(byArtist));
		
		////////////////////////////////
			
		/* 방법2 */
		
		let people = [
						{
							name: 'John',
							surname: 'Doe',
							pet: {
								petName: 'CAT',
								name: 'whiskers',
								age: 1
							}
						},
						{
							name: 'John',
							surname: 'Doe',
							pet: {
								petName: 'DOG', 
								name: 'Dexter',
								age: 4
							}
						},
						{
							name: 'Jane',
							surname: 'Doe',
							pet: {
								petName: 'CAT',
								name: 'Fluffy',
								age: 10
							}
						},
						{
							name: 'Jane',
							surname: 'Doe',
							pet: {
								petName: 'CAT',
								name: 'Dennis',
								age: 3
							}
						}
					];

		/* let result = Object.values(people.reduce((c, {pet,...u}) => {
		  let k = u.name + u.surname;             //Make a key using name and last name
		  let {petName,...p} = pet;                  //Deconstrct pet object
		  type = petName.toLowerCase();              //Make type lower case
		  c[k] = c[k] || u;                       //Initiate if name does not exist
		  c[k][petName] = c[k][petName] || [];          //Initiate if pet does not exist
		
		  c[k][petName].push(p);                     //Add the pet
		  return c;
		}, {})); */
		
		//console.table(result);
			
	</script>
</head>
<body>
</body>
</html>