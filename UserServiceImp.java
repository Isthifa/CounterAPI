 public ResTotalUsersDTO fetchTotalUsers() {
       int c=userRepository.fetchtotalusers();
       ResTotalUsersDTO resTotalUsersDTO= ResTotalUsersDTO.builder()
               .totalUsers(c).build();
       return resTotalUsersDTO;
    }

    @Override
    public ResTotalSellersDTO fetchTotalSellers() {
        List<SellerInfo> sellerInfoList=sellerInfoRepository.findAll();
        ResTotalSellersDTO resTotalSellersDTO= ResTotalSellersDTO.builder()
                .totalSellers(sellerInfoList.size()).build();
        return resTotalSellersDTO;
    }

    @Override
    public ResTotalBuyersDTO fetchTotalBuyers() {
        int count=roleRepository.fetchbuyerscount();
        ResTotalBuyersDTO resTotalBuyersDTO=ResTotalBuyersDTO.builder()
                .totalBuyers(count).build();
        return resTotalBuyersDTO;
    }



    @Override
    public VistorsCountDTO getTotalVisitorsCount() {
        List<VisitorLogoutXref> visitorLogoutXref=visitorLogoutRepo.findAll();
        List<Visitors> visitors=visitorsRepository.findAll();
        VistorsCountDTO vistorsCountDTO= VistorsCountDTO.builder()
                .visitors(visitors.size())
                .loggedIn(visitors.size())
                .loggedOut(visitorLogoutXref.size()).build();
        return vistorsCountDTO;
    }

    @Override
    public List<VisitorsLoginOutDTO> fetchAllLoginLogout() {

        List<Object[]> listall=visitorsRepository.findloginandlogoutofusers();
        //VisitorLoginOut DTO Arraylist to store the data
        List<VisitorsLoginOutDTO> visitorsLoginOutDTOS=new ArrayList<>();

        for(Object[] loginlogout:listall)
        {
           UUID UserID=(UUID)loginlogout[0];
           Date loginTime=(Date) loginlogout[1];
           Date logoutTime=(Date) loginlogout[2];
           VisitorsLoginOutDTO dto=new VisitorsLoginOutDTO(UserID,loginTime,logoutTime);
           visitorsLoginOutDTOS.add(dto);
        }
        return visitorsLoginOutDTOS;
    }
