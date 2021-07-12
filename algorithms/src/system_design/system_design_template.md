# Steps
1. [Clarify the scope of the question & establish requirements](#clarify-the-scope-of-the-question--establish-requirements)
2. [Back of the envelope estimations](#back-of-the-envelope-estimations)
3. [High level Architectural Design](#high-level-architectural-design-with-modules--services-necessary)
4. [Deep dive components](#deep-dive-components)
5. [Identifying Bottlenecks and address non – functional requirements](#identifying-bottlenecks-and-address-non--functional-requirements)
6. [Scaling the design](#scaling-the-design)

## Clarify the scope of the question & establish requirements

### Requirements
1. Functionality – What problem does it solve & What are the features
2. Non-Functionality – efficiency of the system
3. Additional – nice to haves
4. Constraints – Not to have / Can’t haves

### Common Questions to ask & clarify
1. Is this a mobile app? Or a web app? Or both?
2. What is the purpose & what are the important features?
3. How many users are estimated + traffic volume ?
4. Can you give an example of how it should work ?
5. 

## Back of the envelope estimations

### Estimations
1. Traffic Estimates – Number of read & Write per second (expected throughput)
2. Storage Estimates – Storage needed for X years; Average storage vs Max storage. 70% capacity model
3. Bandwidth Estimates – How much is read and written through API
4. Memory Estimates – Caching estimate (80%-20% rule. Cache 20%) (for latency)
5. Estimate Summary - aim for maximal throughput with acceptable latency

### Common Questions to ask & clarify
1.  Read / Write Ratio – Read Heavy vs Write Heavy

## High level Architectural Design with modules / services necessary
1. Modules involved
2. API designs

## Deep dive components 
1. Algorithm Design for each component
2. Flow sequences for use cases

## Identifying Bottlenecks and address non – functional requirements

## Scaling the design

