const socket = io('/')
const videoGrid = document.getElementById('video-grid')

const myPeer = new Peer(undefined, {
    host : '/',
    port : '3001'
})

const myVideo = document.createElement('video')
myVideo.muted = true


// video.setAttribute('playsinline', true);
navigator.mediaDevices.getUserMedia({
    video : true,
    audio : true
}).then((stream) => {
    addVideoStream(myVideo, stream)
    myVideo.setAttribute('playsinline', true);
    
    myPeer.on('call', call => {
        call.answer(stream)
        const video = document.createElement('video') 
        call.on('stream', userVideoStream => {
            addVideoStream(video, userVideoStream)
        })
    })

    socket.on('user-connected', userId => {
        connectToNewUser(userId, stream)
    }) 
})

socket.on('user-disconnected', userId => {
    if(peers[userId]) peers[userId].close()
})

myPeer.on('open', id => {
    socket.emit('join-room', ROOM_ID , id)
})

// socket.emit('join-room', ROOM_ID, id)

function connectToNewUser(userId, stream){
    const call = myPeer.call(userId, stream)
    const video = document.createElement('video')
    call.on('stream', userVideoStream => {
        addVideoStream(video, userVideoStream)
        video.setAttribute('playsinline', true);
    })

    call.on('close', () => {
        video.remove()
    })

    peers[userId] = call
}

function addVideoStream(video, stream){
    video.srcObjext = stream
    video.addEventListener('loadedmetadata', () => {
        video.play()
    })
    videoGrid.append(video)
}