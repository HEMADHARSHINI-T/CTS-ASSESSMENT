
/ 1. JavaScript Basics & Setup
console.log("Welcome to the Community Portal");

window.onload = function() {
    alert("Page Loaded Successfully!");
};

/ 2. Syntax, Data Types, and Operators
const eventName = "Music Fest";
const eventDate = "May 30, 2025";
let availableSeats = 50;

console.log(`${eventName} will be held on ${eventDate}. Seats available: ${availableSeats}`);
availableSeats--; // Decrease seat count on registration

/ 3. Conditionals, Loops, and Error Handling
const events = [
    { name: "Music Fest", date: "2025-05-30", seats: 50 },
    { name: "Art Expo", date: "2025-06-15", seats: 0 },
    { name: "Tech Meetup", date: "2024-12-01", seats: 10 }
];

function displayValidEvents() {
    events.forEach(event => {
        if (new Date(event.date) > new Date() && event.seats > 0) {
            console.log(`Event: ${event.name} | Date: ${event.date}`);
        }
    });
}
displayValidEvents();

function registerUser(eventName) {
    try {
        let event = events.find(e => e.name === eventName);
        if (!event) throw "Event not found!";
        if (event.seats <= 0) throw "No seats available!";
        event.seats--;
        console.log(`Registered for ${event.name}, Remaining seats: ${event.seats}`);
    } catch (error) {
        console.error("Registration Error:", error);
    }
}
registerUser("Music Fest");

/ 4. Functions, Scope, Closures, Higher-Order Functions
function filterEventsByCategory(events, category) {
    return events.filter(event => event.category === category);
}

function createEventTracker() {
    let count = 0;
    return function() {
        count++;
        console.log(`Total registrations: ${count}`);
    };
}

const trackRegistration = createEventTracker();
trackRegistration();

/ 5. Objects and Prototypes
class Event {
    constructor(name, date, seats) {
        this.name = name;
        this.date = date;
        this.seats = seats;
    }

    checkAvailability() {
        return this.seats > 0 ? "Available" : "Full";
    }
}

const musicFest = new Event("Music Fest", "2025-05-30", 50);
console.log(Object.entries(musicFest));

/ 6. Arrays and Methods
const communityEvents = ["Music Fest", "Art Expo", "Tech Meetup"];
communityEvents.push("Food Carnival");

const musicEvents = communityEvents.filter(event => event.includes("Music"));
console.log(musicEvents);

/ 7. DOM Manipulation
document.addEventListener("DOMContentLoaded", () => {
    const eventSection = document.querySelector("#events");
    events.forEach(event => {
        let div = document.createElement("div");
        div.classList.add("eventCard");
        div.innerHTML = `<h3>${event.name}</h3><p>Date: ${event.date}</p>`;
        eventSection.appendChild(div);
    });
});

/ 8. Event Handling
document.querySelector("#registerBtn").onclick = function() {
    alert("You have registered!");
};

document.querySelector("#categoryFilter").onchange = function(event) {
    console.log("Filter selected:", event.target.value);
};

/ 9. Async JS, Promises, Async/Await
async function fetchEvents() {
    try {
        let response = await fetch("https://mockapi.com/events");
        let data = await response.json();
        console.log(data);
    } catch (error) {
        console.error("Error fetching events:", error);
    }
}
fetchEvents();

/ 10. Modern JavaScript Features
const eventList = [...communityEvents];

const { name, date, seats } = new Event("Workshop", "2025-06-25", 40);
console.log(`Event: ${name}, Date: ${date}, Seats: ${seats}`);

/ 11. Working with Forms
document.querySelector("#registrationForm").addEventListener("submit", function(event) {
    event.preventDefault();
    let userName = event.target.elements.name.value;
    let userEmail = event.target.elements.email.value;
    console.log(`User: ${userName}, Email: ${userEmail}`);
});

/ 12. AJAX & Fetch API
function sendRegistration(user) {
    fetch("https://mockapi.com/register", {
        method: "POST",
        body: JSON.stringify(user),
        headers: { "Content-Type": "application/json" }
    })
    .then(response => response.json())
    .then(data => console.log("Registration Successful", data))
    .catch(error => console.error("Registration Failed", error));
}

sendRegistration({ name: "John Doe", event: "Music Fest" });

// 13. Debugging and Testing
console.log("Debugging started");
console.debug("Event data:", events);

/ 14. jQuery and JS Frameworks
$(document).ready(() => {
    $("#registerBtn").click(() => alert("Registered via jQuery"));
    $(".eventCard").fadeIn();
});
