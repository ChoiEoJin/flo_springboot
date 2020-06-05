플레이리스트
=
플레이리스트 목록 API
-
```
GET /playlist/{user_id} sample call: GET /playlist/1
```
- Request
    - Header
    ```
    {
        "Authorization": "LOGGED_IN"
    }
    ```
    - Body
    ```
    {}
    ```
- Response
    - BODY
    ```
    {
        "statusCode": int, // (SUCCESS 200)
        "playlists": [
            {
                "playlistId": int, // 플레이리스트 id
                "playlistName": string, // 플레이리스트명
                "userId": int, // 유저 pk
                "songCount": int // 플레이리스트에 추가된 곡 수
            },
            ....
        ]
    }
    
    
    //sample
    {
        "statusCode": 200, 
        "playlists": [
            {
                "playlistId": 1,
                "playlistName": "my_playlist1", 
                "userId": 1, 
                "songCount": 0 
            },
            {
                "playlistId": 2,
                "playlistName": "my_playlist2",
                "userId": 1,
                "songCount": 0
            }
        ]
    }
    ```
    
플레이리스트 생성 API
-
```
POST /playlist/create
```
- Request
    - Header
    ```
    {
        "Authorization": "LOGGED_IN"
    }
    ```
    - Body
    ```
    {
        "playlistName" : string // 생성할 플레이리스트 명
        "userId": number // 유저 ID
    }
    
    //sample
    {
        "playlistId" : "test_playlist"
        "userId": 1
    }
    ```
- Response
    - BODY
    ```
    {
        "statusCode": int, // 상태코드 (SUCCESS 200)
        "resultCount": int // 생성된 플레이리스트 수
    }
    
    //sample
    {
        "statusCode": 200,
        "resultCount": 1
    }
    ```    

Playlist 노래, 앨범 추가 API
-
```
POST /playlist/addsong
```
- Request
    - Header
    ```
    {
        "Authorization": "LOGGED_IN"
    }
    ```
    - Body
    ```
    {
        "playlistId" : int, //플레이리스트 ID
        "songs": [String], //플레이리스트에 추가할 song의 id 배열
        "album": { 
            "id": int //플레이리스트에 추가할 album id
        }
    }
    
    //sample
    {
        "playlistId" : "1",
        "songs": ["1", "2"],
        "album": {
            "id": "3"
        }
    }
    ```
- Response
    - BODY
    ```
    {
        "statusCode": int, //상태코드 (SUCCESS 200)
        "resultCount": int //플레이리스트에 추가된 곡 수
    }
    
    //sample
    {
        "statusCode": 200, 
        "resultCount": 13
    }
    ```    

Playlist 삭제 API
-
```
POST /playlist/remove
```
- Request
    - Header
    ```
    {
        "Authorization": "LOGGED_IN"
    }
    ```
    - Body
    ```
    {
        "playlistId" : int, //플레이리스트 ID
        "userId" : int // 유저 ID
    }
    
    //sample
    {
        "playlistId" : "1", //플레이리스트 ID
        "userId" : "1" // 유저 ID
    }
    ```
- Response
    - BODY
    ```
    {
        "statusCode": int, //상태코드 (SUCCESS 200)
        "resultCount": int //삭제된 플레이 리스트 
    }
    
    //sample
    {
        "statusCode": 200, 
        "resultCount": 1
    }
    ```   
