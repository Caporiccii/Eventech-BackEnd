package com.bandtech.eventech.model.V1;

import lombok.*;
@AllArgsConstructor
@ToString

public class EndPoints {

    public final String userEndpoint = "https://eventech.outsystemscloud.com/Core/rest/User/v1/{userid}";
    public final String userPostEndpoint = "https://eventech.outsystemscloud.com/Core/rest/User/v1";

    public final String eventPostEndpoint = "https://eventech.outsystemscloud.com/Core/rest/Event/v1";
    public final String eventEndpoint = "https://eventech.outsystemscloud.com/Core/rest/Event/v1/{EventId}";
    public final String eventEndpointV2 = "https://eventech.outsystemscloud.com/Core/rest/Event/v2/{EventId}";
    public final String eventEndpointV2List = "https://eventech.outsystemscloud.com/Core/rest/Event/v2/events";

    public final String companyEndpoint = "https://eventech.outsystemscloud.com/Core/rest/Company/v1/{CompanyId}";
    public final String companyPostEndpoint = "https://eventech.outsystemscloud.com/Core/rest/Company/v1";

    public final String ticketPostEndpoint = "https://eventech.outsystemscloud.com/Core/rest/Ticket/v1";
    public final String ticketEndpoint = "https://eventech.outsystemscloud.com/Core/rest/Ticket/v1/{TicketId}";

    public final String placeEndpoint = "https://eventech.outsystemscloud.com/Core/rest/Place/v1/{PlaceId}";
    public final String placePostEndpoint = "https://eventech.outsystemscloud.com/Core/rest/Place/v1";

    public final String categoryPostEndpoint = "https://eventech.outsystemscloud.com/Core/rest/Category/v1";
    public final String categoryEndpoint = "https://eventech.outsystemscloud.com/Core/rest/Category/v1/{CategoryId}";

    public final String addressEndpoint = "https://eventech.outsystemscloud.com/Core/rest/Address/v1/{AddressId}";
    public final String addressPostEndpoint = "https://eventech.outsystemscloud.com/Core/rest/Address/v1";


}


