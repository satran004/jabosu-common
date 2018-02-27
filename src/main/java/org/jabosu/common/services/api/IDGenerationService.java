package org.jabosu.common.services.api;

import java.util.UUID;

/**
 *
 * @author satya
 */
public interface IDGenerationService {
    
    public String getNextAvailableUserId();
    
    public String getNextAvailableServiceId(String countryCode);
    
    public String getUniqueJobId(String jobType);
    
    public UUID getNextConversationId();
    
    public UUID getNextMessageId();
    
    public UUID getNextWallMessageId();
    
    public String getNextDealId(String countryCode);
    
    public String getNextBookingId(String countryCode);
    
    public String getNextCalendarEventId();
    
    public String getNextServiceBookingId();
}
